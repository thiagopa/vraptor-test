<c:forEach var="error" items="${errors}">
    <p>${error.message}</p>
</c:forEach>

<form action="<c:url value='/product/add'/>">
    Name:             <input type="text" name="product.name" value="${product.name}"/><br/>
    Description:    <input type="text" name="product.description" value="${product.description}"/><br/>
    Price:            <input type="text" name="product.price" value="${product.price}"/><br/>
    <input type="submit" value="Save" />
</form>