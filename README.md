# api-users-cars
Aplicação de cadastro de Usuários e Carros

### Histórias de Usuário
1-Como um administrador, eu quero ser capaz de criar novos usuários no sistema, fornecendo informações como nome, e-mail e senha, para que novos usuários possam acessar o sistema.

2-Como um usuário, eu quero poder me registrar no sistema fornecendo informações como nome, e-mail e senha, para que eu possa acessar minha conta posteriormente.

3-Como um usuário, eu quero poder fazer login no sistema usando meu e-mail e senha, para acessar minhas informações pessoais e veículos cadastrados.

4-Como um usuário, eu quero ser capaz de adicionar novos veículos à minha conta, inserindo detalhes como marca, modelo, ano e placa do veículo, para registrar meus próprios veículos no sistema.

5-Como um usuário, eu quero poder visualizar uma lista dos veículos que possuo registrados no sistema, incluindo suas informações detalhadas, como marca, modelo, ano e placa, para revisar meus veículos cadastrados.

6-Como um usuário, eu quero poder editar as informações de um veículo que possuo, como marca, modelo, ano ou placa, para manter meus registros de veículos atualizados.

7-Como um usuário, eu quero poder excluir um veículo que possuo do sistema, removendo-o permanentemente da minha lista de veículos registrados, caso eu não possua mais o veículo ou não queira mais registrá-lo.

8-Como um usuário, eu quero poder pesquisar meus veículos registrados com base em critérios específicos, como marca, modelo ou ano, para encontrar informações relevantes rapidamente.

9-Como um usuário, eu quero poder visualizar detalhes específicos de um veículo que possuo, como informações de manutenção, quilometragem ou data de compra, para monitorar e gerenciar meu veículo de maneira eficaz.

### Solução

Foi implementado uma aplicação com spring boot API utilizando Spring Boot (utilizando Spring security e JWT Token(para autenticação), H2 como banco de dados(tanto para aplicação como para os testes)) e com Angular 14 para a interface (utilizando componentes, rotas, serviços, intercepetadores).

### Execução e build
#### Backend
Para execução local do backend, é necessário executar a classe ApiApplication.

#### Frontend
Para execução local do front, é necessário executar o comando ng serve dentro da pasta frontend.
