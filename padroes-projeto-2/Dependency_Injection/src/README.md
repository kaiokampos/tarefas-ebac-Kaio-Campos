# O que é injeção de dependência em Java?
Em vez de criar objetos manualmente dentro de uma classe, a injeção de dependência permite que você especifique as 
dependências necessárias e o contêiner de injeção (geralmente um framework) cuida de fornecer as instâncias adequadas 
dessas dependências.

As injeções de dependências são uma forma de realização do padrão de Inversão de Controle (IoC), onde neste caso, 
o controle de construir objetos é invertido e passa a ser uma responsabilidade do contêiner, ou de algum componente que 
possa assumir este controle, e não mais do implementador.

A utilização da injeção de dependências se tornou amplamente difundida, desde 2003, com a utilização corporativa do 
framework Spring, Atualmente o projeto Spring Framework possui outras frentes além da injeção de dependências, atuando
também na parte de acesso a dados, segurança, mobile e de integração com redes sociais.

Pelo que eu pude entender, lendo além desse simplório resumo, esse padrão é a base para desacoplar o software, deixando
tudo mais "livre", para melhor manutenção, e entendimento do código. 