let html_about_product;
let table2 = document.getElementById('productL');
let idEl = localStorage.getItem('selectedProduct');
let url = `http://localhost:9898`;
fetch(`${url + '/products/getById/'+ idEl}`, {
    method: 'GET',
}).then(data => {
    return data.json();
}).then((about_product) => {
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

    let userId = null;
    let productId = about_product.id;
     fetch(url + '/users/user')
        .then(response => response.json())
        .then(value => {
            userId = value.id;
    const create = document.getElementById('form-input-id');
    create.addEventListener('submit', async function (event) {
        event.preventDefault();
        let commentSave = document.getElementById('textarea-id').value;
        await fetch(url + "/comment/" + productId + "/" + userId, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                comment: commentSave
            })
        });
    })
});
    let commentList = document.getElementById('comment-list');
    let param = '';
    about_product.productComments.forEach(function (iter){
    let fetchComments = `
<div class="div-one">
    <div class="div-two">
        <div class="div-three">
            ${iter.comment}(${iter.user.username})
        </div>
    </div>
</div>
`;
    param += fetchComments;
});
    commentList.innerHTML = param;
    table2.innerHTML = html_about_product;
})