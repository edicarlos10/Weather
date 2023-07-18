# Apresentação
No link a seguir, segue meu site com breve apresentação e contatos.

https://edicarlos.dev.br/
# O Projeto - Clima
Aplicativo, um desafio, de consumo de API sobre previsão de tempo.

Esse aplicativo foi construido seguindo a [Open Weather API](https://openweathermap.org/)

Em resumo, foi demonstrado como criar um APP Android usando **Kotlin e Arquitetura limpa + Conceitos de SOLID** de _Previsão de tempo._

# Como rodar
Apenas clone o projeto, e sync o gradle via Android Studio.

E, crie um conta na [Open Weather](https://openweathermap.org/) habilitando uma **Key** para ser usada nas requisições

Também é possivel utilizar duas maneiras para trabalhar com UI:
- **XML**
- **Compose**

- Para usar com xml **comente** as linhas no Manifest **de 29 a 33.**
- Para usar Compose as linhas **38 a 42** devem estar comentadas.

Não deverá ter problemas.
# Arquitetura e Tecnologias
A estrutura está **bem sólida**, e a arquitetura está bem definida.

Seguindo com: 
- **Clean Architecture, Conceitos de SOLID**
- **MVVM, Live Data**
- **Kotlin como linguagem de programação**
- **Retrofit para trabalhar com a API**
- **Koin para DI**
- **Glide para carregamento de imagens**
- **Mockito para testes automatizados**
- **RxJava para eventos assincronos**
- **ViewBinding para apoio com a UI**
- **JetPack Compose para UI**

Outros detalhes podem ser _conferidos nos arquivos do projeto._
# Oque faltou
- Melhorar a parte visual
- Melhoria de código, como refatorações e remoção de código morto

# Melhorias
Algumas melhorias _deverão ser feitas:_

- Criar e melhorar a UI 
- Integração com as actions do gitHub (rodar lint, unit testes por ex)

Abaixo, segue um exemplo de como poderá ser a UI

[Link de UI](https://www.behance.net/gallery/9650557/iOS7-Weather-App)

# Testes
Testes unitários foram criados para a camada de Network e Domain. Elas englobam:
- Remote data 
- Repository
- Use Cases

Para executar os testes basta abrir o arquivo pelo android studio e apertar na flecha verde do inicio da classe de teste/

# Licensa
O código pode ser usado livremente, **isentando o autor** de qualquer responsabilidade de seu uso.
