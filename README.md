# CheckSpawn Pixelmon

Este repositório contem um pequeno mod para Minecraft/Pixelmon baseado na API NeoForge. Seu objetivo é oferecer um comando prático para consultar as condições de surgimento (spawns) de qualquer Pokémon.

## Funcionalidades

- **Comando `/checkspawn <pokemon>`**: pesquisa dados de aparição do Pokémon informado. O comando aceita trechos do nome e fornece sugestões dinâmicas de acordo com os dados carregados.
- **Busca flexível**: caso a busca retorne múltiplos Pokémon, é exibida uma lista para refinar a consulta.
- **Dados carregados via JSON**: todas as informações de spawns estão no arquivo `data/checkspawn/spawns.json`, que acompanha este repositório. O mod faz o parsing desse arquivo na inicialização.
- **Mensagens detalhadas**: cada resultado mostra nível mínimo/máximo, horários, tipos de localização, biomas, anti-biomas e raridade de aparecimento.

## Como usar

1. Certifique-se de possuir um ambiente de desenvolvimento NeoForge configurado para o Minecraft com Pixelmon.
2. Copie ou substitua `src/main/resources/data/checkspawn/spawns.json` com a lista de spawns que desejar. O repositório já fornece um exemplo completo (`spawns.json`).
3. Compile o mod normalmente (por exemplo, via Gradle) e coloque o arquivo gerado na pasta `mods` do seu cliente ou servidor.
4. No jogo, utilize o comando `/checkspawn <pokemon>` para verificar as condições de surgimento. Se houver mais de um resultado, o mod indicará os nomes encontrados.

## Alterações futuras sugeridas

- Atualizar periodicamente o `spawns.json` conforme novas versões do Pixelmon.
- Acrescentar opções extras ao comando para filtrar por bioma, horário ou nível.
- Permitir carregamento do arquivo de spawns sem a necessidade de recompilar o mod (ex: via diretório `config`).

## Possíveis novas implementações

- Integração com banco de dados ou API para atualizar os spawns dinamicamente.
- Comandos adicionais para listar todos os Pokémon que podem aparecer em determinado bioma ou horário.
- Interface gráfica in game para facilitar a busca e a leitura das informações.
- Sistema de traduções para personalizar as mensagens exibidas.

## Contribuição

Pull requests são bem-vindos! Fique à vontade para propor melhorias de código ou ajustes no banco de spawns.

