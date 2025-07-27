# CheckSpawn Pixelmon

Este repositório contém um pequeno mod para Minecraft com o mod Pixelmon, desenvolvido com a API NeoForge. Seu objetivo é oferecer um comando prático para consultar as condições de surgimento (spawns) de qualquer Pokémon no jogo.

## 🔧 Funcionalidades

- **Comando `/checkspawn <pokemon>`**: pesquisa as condições de aparição do Pokémon informado. O comando aceita trechos do nome e fornece sugestões dinâmicas com base nos dados carregados.
- **Busca flexível**: caso o nome informado retorne múltiplos Pokémon, uma lista com as possíveis correspondências será exibida.
- **Leitura de dados via JSON**: todas as informações de spawn são extraídas do arquivo `data/checkspawn/spawns.json`, incluído neste repositório. O mod realiza o parsing desse arquivo na inicialização.
- **Mensagens detalhadas**: para cada resultado, são mostrados os níveis mínimo/máximo, horários, tipos de localização, biomas, anti-biomas e raridade.

## ▶️ Como usar

1. Certifique-se de possuir um ambiente de desenvolvimento com NeoForge configurado para Minecraft e Pixelmon.
2. Substitua ou edite o arquivo `src/main/resources/data/checkspawn/spawns.json` com os dados de spawn desejados. O repositório já fornece um exemplo funcional.
3. Compile o mod normalmente (via Gradle, por exemplo) e copie o JAR gerado para a pasta `mods` do seu cliente ou servidor.
4. Dentro do jogo, utilize o comando `/checkspawn <pokemon>` para verificar as condições de surgimento. Caso múltiplos resultados sejam encontrados, o mod indicará todos os nomes correspondentes.

## 🚀 Melhorias futuras sugeridas

- Atualizar o `spawns.json` automaticamente com base em versões mais recentes do Pixelmon.
- Adicionar filtros opcionais ao comando: por bioma, horário, raridade, etc.
- Permitir carregamento externo de dados de spawn via diretório `config`, sem recompilar o mod.

## 💡 Novas funcionalidades possíveis

- Integração com APIs externas ou bancos de dados para atualização dinâmica dos spawns.
- Novos comandos como `/checkbiome` para listar todos os Pokémon que aparecem em determinado bioma.
- Interface gráfica in-game para facilitar buscas e leitura de dados.
- Sistema multilíngue com tradução das mensagens.

## 🤝 Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues, relatar bugs ou propor melhorias e otimizações no código ou no `spawns.json`.