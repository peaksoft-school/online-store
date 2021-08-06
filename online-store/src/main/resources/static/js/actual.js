let html_actual = ' ';
fetch("http://localhost:9898/products/actual")
    .then(data=>{
        return data.json()
    }).then(result=>{
    result.forEach(product=>{
        html_actual += `<div class="col-md-4" >
                    <br>
                    <a href="#">
                    <div class="container">
                        <img src="${product.productPicture}" alt=""
                             width="220" height="200">
                    </div>
                    <div class="text-center-left">
                        <p>${product.name}</p>
                        <p1 style="color: black">price:${product.productPrice}</p1>
                        <br>
                    </div>
                    </a>
                    <br>
                </div>
`;
    })
    console.log(html_actual)
    document.getElementById('productList').innerHTML = html_actual;
})