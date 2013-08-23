<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/jsp/cabecalho.jsp"%>

<script src="../js/filme.js"></script>

<div class="container" id="container">
	<div class="container-fluid main">
		<div class="row-fluid">

			<div class="span12">
				<div class="well" id="movie-choice">
					<fieldset>
						<legend>Escolher Filme</legend>
						
						<div class="row">
							<div class="span6 text-center">
								<img src="" id="filme-left-img" class="img-polaroid movie-img" />
								<div class="span12 movie-name">
									<span id="filme-left"></span>
								</div>
							</div>
							<div class="span6 text-center">
								<img src="" id="filme-right-img" class="img-polaroid movie-img" />
								<div class="span12 movie-name">
									<span id="filme-right"></span>
								</div>
							</div>
						</div>
					</fieldset>
				</div>

				<div class="well" id="div-btn-form">
					<form>
						<fieldset>
							<legend>Dados do Usuário</legend>
							
							<div class="row">
								<label class="span3">Nome</label>
								<label class="span3">E-mail</label>
							</div>
							<div class="row">
								<span class="span3">
									<input type="text" id="nome" class="input-medium" maxlength="80" />
								</span>
								<span class="span3">
									<input type="text" id="email" class="input-medium" maxlength="80" />
								</span>
								<span class="span4">
									<button type="button" id="btn-cancel" class="btn">Votar Novamente</button>
									<button type="button" id="btn-salvar" class="btn btn-primary">Registrar Votos</button>
								</span>
							</div>
						</fieldset>
					</form>
				</div>
				
				<div class="well" id="resultados">
					<fieldset>
						<legend>Resultado Geral dos Filmes</legend>
						
						<div class="row">
							<div class="span3 text-center">
								<img src="" id="filme-1-img" class="img-polaroid" width="168" />
								<div>
									<span id="filme-1"></span>
								</div>
							</div>
							<div class="span3 text-center">
								<img src="" id="filme-2-img" class="img-polaroid" width="168" />
								<div>
									<span id="filme-2"></span>
								</div>
							</div>
							<div class="span2 text-center">
								<img src="" id="filme-3-img" class="img-polaroid" width="168" />
								<div>
									<span id="filme-3"></span>
								</div>
							</div>
							<div class="span2 text-center">
								<img src="" id="filme-4-img" class="img-polaroid" width="168" />
								<div>
									<span id="filme-4"></span>
								</div>
							</div>
							<div class="span2 text-center">
								<img src="" id="filme-5-img" class="img-polaroid" width="168" />
								<div>
									<span id="filme-5"></span>
								</div>
							</div>
						</div>
					</fieldset>
					<fieldset style="margin-top: 22px;">
						<legend>Resultado Individual</legend>
						
						<div class="row">
							<div class="span3 text-center">
								<img src="" id="filme-ind-1-img" class="img-polaroid" width="168" />
								<div>
									<span id="filme-ind-1"></span>
								</div>
							</div>
							<div class="span3 text-center">
								<img src="" id="filme-ind-2-img" class="img-polaroid" width="168" />
								<div>
									<span id="filme-ind-2"></span>
								</div>
							</div>
							<div class="span2 text-center">
								<img src="" id="filme-ind-3-img" class="img-polaroid" width="168" />
								<div>
									<span id="filme-ind-3"></span>
								</div>
							</div>
							<div class="span2 text-center">
								<img src="" id="filme-ind-4-img" class="img-polaroid" width="168" />
								<div>
									<span id="filme-ind-4"></span>
								</div>
							</div>
							<div class="span2 text-center">
								<img src="" id="filme-ind-5-img" class="img-polaroid" width="168" />
								<div>
									<span id="filme-ind-5"></span>
								</div>
							</div>
						</div>
					</fieldset>
					<div class="row" style="margin-top: 22px;">
						<span class="span8 text-center">
						</span>
						<span class="span4 text-center">
							<button type="button" id="btn-novamente" class="btn btn-primary">Votar Novamente</button>
						</span>
					</div>
				</div>
				
			</div>
		</div>
	</div>
	<hr>

	<footer>
		<p>&copy; Vote no Filme - by Paulo Alves Júnior - BlueSoft</p>
	</footer>
</div>

<script src="../js/vendor/bootstrap.min.js"></script>

</body>
</html>