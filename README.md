# java-mensagens

Neste repositorio tenho 2 projetos spring boot o primeiro é o projeto consumer que é onde se encontra os consumidores do apache kafka e rabbitMq tratase se um projeto spring boot comum onde apenas é necessario fazer o apontamento no arquivo application.properties.
Depois de feitas as configurações necessarias, apenas rodar a classe ConsumerApplication é o suficiente para rodar esse peojeto.

O segundo projeto é o testProgramador assim como o outro projeto também se trata de uma aplicação spring boot, contudo nessa aplicação temos tanto configuração no application.properties como em arquivos de configuração em classes java, mais especificamente no pacote "br.com.atlantico.testProgramador.configuration", sendo que posso selecionar o profile no application.properties usando a configuracao "spring.profiles.active=development" ou "spring.profiles.active=production"
Depois de feitas as configurações necessarias, apenas rodar a classe TestProgramadorApplication é o suficiente para rodar esse projeto.

