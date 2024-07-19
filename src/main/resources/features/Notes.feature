#language: pt
#enconding: UTF-8

Funcionalidade: Notas

	Cenario: Criar Categoria e Mover
	Dado que eu estou usando o aplicativo de Notas
	Quando eu seleciono para ver minhas categorias
	E crio uma categoria chamada "javascript"
	E crio uma categoria chamada "java"
	E movo a categoria "java" pra cima
	Entao a categoria "java" esta em primeira
	E clico para remover "javascript"
	Entao javascript e removido
	
	Cenario: Criar, Editar, mover, concluir Lista e manual
	Dado que eu estou usando o aplicativo de Notas
	Quando eu crio uma lista chamada "java"
	E clico no tutorial
	Entao vejo o tutorial
	Quando eu volto 
	E crio item "objeto"
	E crio item "classe"
	E movo objeto pra baixo
	E concluo os itens
	E excluo os concluidos
	Entao foi tudo concluido
	
	Cenario: Criar lista com senha
	Dado que eu estou usando o aplicativo de Notas
	Quando eu crio uma lista chamada "java"
	E adiciono uma senha
	E eu volto
	E clico na lista para abrir com senha
	Entao a lista e exibida
	