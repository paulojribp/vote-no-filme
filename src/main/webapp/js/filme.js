$(document).ready(function () {
	
	Filme.carregarFilmes();
	$('#div-btn-form').hide();
	$('#resultados').hide();
	
	$('#filme-right-img').click(function() {
		VotoController.votos[$('#filme-right').attr('idx')].computarVoto();
		VotoController.proxFilme("right");
	});
	$('#filme-left-img').click(function() {
		VotoController.votos[$('#filme-left').attr('idx')].computarVoto();
		VotoController.proxFilme("left");
	});
	
	$('#btn-cancel').click(function() {
		Filme.carregarFilmes();
		Filme.clearForm();
		VotoController.reset();
	});
	
	$('#btn-novamente').click(function() {
		Filme.carregarFilmes();
		Filme.clearForm();
		VotoController.reset();
	});
	
	$('#btn-salvar').click(function() {
		VotoController.registrar();
	});
	
});


var Filme = {
	carregarFilmes : function() {
		$.ajax({
			url: '../filme/list',
			method: 'GET',
			success: function(data) {
				var lista = data.list;
				
				for (var x = 0, size = lista.length; x < size; x++) {
					voto = new Voto();
					voto.filme = lista[x];
					voto.nome = VotoController.nomeUsuario;
					voto.email = VotoController.emailUsuario;
					
					VotoController.votos[x] = voto;
				}
				
				VotoController.reordenaArrayVoto();
				VotoController.populateLeft(0, VotoController.votos[0].filme.nome, 
						VotoController.votos[0].filme.path, VotoController.votos[0].filme.descricao);
				VotoController.populateRight(1, VotoController.votos[1].filme.nome, 
						VotoController.votos[1].filme.path, VotoController.votos[1].filme.descricao);
			},
			error: function(err) {
				console.log(err);
			}
		});
	},
	
	clearForm : function() {
		$('#nome').val('');
		$('#email').val('');
		
	}
};


function Voto() {
	this.filme = {};
	this.nome = "";
	this.email = "";
	this.escolhas = 0;
	this.votado = false;
}

Voto.prototype.computarVoto = function() {
	this.escolhas++;
	this.votado = true;
};

var VotoController = {
	nomeUsuario : "",
	emailUsuario : "",
	votos : [],
	escolhidos : []
};

VotoController.reset = function() {
	$('#div-btn-form').hide();
	$('#resultados').hide();
	$('#movie-choice').show();
};

VotoController.proxFilme = function(side) {
	var filmeMenosVotado = 0;
	var temFilmeMenosVotado = false;
	
	for (var x=0, size=VotoController.votos.length; x<size; x++) {
		if (side === 'left' && x == $('#filme-right').attr('idx')) {
			continue;
		} else if (side === 'right' && x == $('#filme-left').attr('idx')) {
			continue;
		}
		
		if (!VotoController.votos[x].votado) {
			filmeMenosVotado = x;
			temFilmeMenosVotado = true;
			break;
		}
	}
	
	console.log("Tem filme menos votado? - " + temFilmeMenosVotado);
	
	if (!temFilmeMenosVotado) {
		console.log("Filmes antes da remoção: " + VotoController.votos.length);
		for (var x=0; x < VotoController.votos.length; x++) {
			if (VotoController.votos[x].votado) {
				VotoController.votos[x].votado = false;
			} else {
				VotoController.escolhidos[VotoController.escolhidos.length] = VotoController.votos[x];
				if (x != VotoController.votos.length-1) {
					VotoController.votos[x] = VotoController.votos[VotoController.votos.length-1];
				}
				VotoController.votos[x].votado = false;
				VotoController.votos.splice(VotoController.votos.length-1,1);
				console.log("Filme menos votado " + VotoController.escolhidos[VotoController.escolhidos.length-1].filme.nome);
				side = "both";
			}
		}
		VotoController.reordenaArrayVoto();
		console.log("Filmes depois da remoção: " + VotoController.votos.length);
		if (VotoController.votos.length < 2) {
			VotoController.escolhidos[VotoController.escolhidos.length] = VotoController.votos[0];
			$("#movie-choice").hide();
			$('#div-btn-form').show();
			return;
		}
	}
	
	if (side === "left") {
		VotoController.populateLeft(filmeMenosVotado, VotoController.votos[filmeMenosVotado].filme.nome,
				VotoController.votos[filmeMenosVotado].filme.path, VotoController.votos[filmeMenosVotado].filme.descricao);
	} else if (side === "right") {
		VotoController.populateRight(filmeMenosVotado, VotoController.votos[filmeMenosVotado].filme.nome,
				VotoController.votos[filmeMenosVotado].filme.path, VotoController.votos[filmeMenosVotado].filme.descricao);
	} else {
		VotoController.populateLeft(0, VotoController.votos[0].filme.nome, 
				VotoController.votos[0].filme.path, VotoController.votos[0].filme.descricao);
		VotoController.populateRight(1, VotoController.votos[1].filme.nome, 
				VotoController.votos[1].filme.path, VotoController.votos[1].filme.descricao);
	}
	
};

VotoController.reordenaArrayVoto = function() {
	for (var x=VotoController.votos.length; x > 0; x--) {
		var num = Math.floor(Math.random() * (x - 1));
		var v = VotoController.votos[x-1];
		VotoController.votos[x-1] = VotoController.votos[num];
		VotoController.votos[num] = v;
	}
};

VotoController.registrar = function() {
	var votos = "";
	for (var x=0; x<VotoController.escolhidos.length; x++) {
//		votos[x] = {
//			"votos.nome" : $("#nome").val(),
//			"votos.email" : $("#email").val(),
//			"votos.posicao" : VotoController.escolhidos[x].escolhas,
//			"votos.filme.id" : VotoController.escolhidos[x].filme.id
//		};
		votos += "votos["+x+"].nome="+$("#nome").val() + "&votos["+x+"].email="+$("#email").val()
			+ "&votos["+x+"].quantidade="+VotoController.escolhidos[x].escolhas
			+ "&votos["+x+"].filme.id="+VotoController.escolhidos[x].filme.id + "&";
	}
//	var dataToSend = {"votos[]": votos};
	
	console.log(votos);
	
	$.ajax({
		url: '../filme/registrar',
		method: 'POST',
//		contentType : 'application/json',
		data: votos,
		success: function(data) {
			VotoController.exibirResultado();
		},
		error: function(data) {
			console.log('Erro ao tentar registar votos');
			console.log(data);
		}
	});
};

VotoController.exibirResultado = function() {
	$.ajax({
		url: '../filme/resultadoVotos',
		method: 'GET',
		success: function(data) {
			var lista = data.list;
			
			for (var x=0; x<lista.length; x++) {
				VotoController.populateResultado(x+1, lista[x].nome, lista[x].path, lista[x].quantidadeVotos);
			}
			
			VotoController.populateResultado("ind-5", VotoController.escolhidos[0].filme.nome, VotoController.escolhidos[0].filme.path, VotoController.escolhidos[0].escolhas);
			VotoController.populateResultado("ind-4", VotoController.escolhidos[1].filme.nome, VotoController.escolhidos[1].filme.path, VotoController.escolhidos[1].escolhas);
			VotoController.populateResultado("ind-3", VotoController.escolhidos[2].filme.nome, VotoController.escolhidos[2].filme.path, VotoController.escolhidos[2].escolhas);
			VotoController.populateResultado("ind-2", VotoController.escolhidos[3].filme.nome, VotoController.escolhidos[3].filme.path, VotoController.escolhidos[3].escolhas);
			VotoController.populateResultado("ind-1", VotoController.escolhidos[4].filme.nome, VotoController.escolhidos[4].filme.path, VotoController.escolhidos[4].escolhas);
			
			$('#resultados').show();
			$('#movie-choice').hide();
			$('#div-btn-form').hide();
		},
		error: function(data) {
			console.log('Não foi possível obter os dados de votação');
			console.log(data);
		}
	});
};

VotoController.populateResultado = function(pos, name, path, qtdVotos) {
	$("#filme-"+pos).text(name + " (" +qtdVotos + " Votos)");
	$("#filme-"+pos+"-img").attr("src", "../"+path);
};
VotoController.populateLeft = function(index, name, path, descricao) {
	$("#filme-left").text(name);
	$("#filme-left").attr("idx", index);
	$("#filme-left-img").attr("src", "../"+path);
	$("#filme-left-img").removeAttr("title");
	$("#filme-left-img").attr("title", descricao);
	$("#filme-left-img").tooltip({delay:{show: 500, hide: 100 },placement:"left"});
};
VotoController.populateRight = function(index, name, path, descricao) {
	$("#filme-right").text(name);
	$("#filme-right").attr("idx", index);
	$("#filme-right-img").removeAttr("title");
	$("#filme-right-img").attr("src", "../"+path);
	$("#filme-right-img").attr("title", descricao);
	$("#filme-right-img").tooltip({delay:{show: 500, hide: 100 },placement:"right"});
};



