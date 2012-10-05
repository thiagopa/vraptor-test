Lista de Produtos

<c:forEach var="product" items="${productList}">
    <p>${product.name} "${product.description}" Custa ${product.price}</p>
</c:forEach>