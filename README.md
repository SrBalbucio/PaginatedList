# PaginatedList
Se você precisar dividir uma lista em páginas com quantidades específicas de itens, isso pode te ajudar. Criei pensando em usar em comandos spigot mas pode ter outras utilidades dependendo do seu projeto.
<br>
If you need to break a list into pages with specific amounts of items, this can help. I created it thinking about using spigot commands but it may have other uses depending on your project.

## Importando para o seu projeto
Se você usa maven então:
Se você usa gradle então:

## Criando um PaginatedList
```java
// Primeiramente você deve ter uma lista
// Digamos que eu tenha uma lista com 100 itens
List<String> list = new ArrayList<>();

// Com a lista em mãos vamos criar o Paginated
// Ao criar um PaginatedList você deve informar o seu Tipo de Objeto (aqui no caso String)
// E informar no construtor a lista e a quantidade máxima de itens por página
// Após isso a lista já estará separada em páginas
PaginatedList<String> paginated = new PaginatedList<>(list, 10);

paginated.getMaxPages(); // Retorna a quantidade máxima de Páginas
paginated.getPage(page); // Retorna a lista de itens de uma página
paginated.hasNext(page); // Verifica se há uma página após essa;
paginated.has(page); // Verifica se há uma página
paginated.add(newList); // Adiciona novos itens a serem paginados
```
