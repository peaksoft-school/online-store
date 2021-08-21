let html_about_product = ' ';
let table2 = document.getElementById('productL');
let idEl = localStorage.getItem('selectedProduct');
const url = `http://localhost:9898/products/getById/${idEl}`
fetch(`${url}`, {
    method: 'GET',
}).then(data => {
    return data.json()
}).then((about_product) => {
    console.log(about_product);
    html_about_product += `
                         <div class="col-md-12" style="display: flex; flex-wrap: wrap">
                    <div class="col-md-6" >
                      <img src="${about_product.productPicture}" alt=""
                             width="420" height="400">
                    </div>
                    <div class="col-md-6">
                    <p ><b>Имя: </b>${about_product.name}</p>
                        <p ><b>Цена: </b>${about_product.productPrice}</p>
                        <p ><b>Производитель: </b>${about_product.description.productManufacturer}</p>
                        <p><b>Гарантия: </b>${about_product.description.productGuarantee}</p>
                        <p><b>Цвет: </b>${about_product.description.productColor}</p>
                        <p><b>Размер: </b>${about_product.description.productDimensions}</p>
                        <p><b>Вес: </b>${about_product.description.productWeight}</p>
                        </div>
                    </div>
`;

    console.log(html_about_product)
    table2.innerHTML = html_about_product;
})