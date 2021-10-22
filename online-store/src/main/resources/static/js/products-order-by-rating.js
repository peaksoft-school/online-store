window.MyLib = {
    selectedProduct: 0
};

fetch("http://localhost:9898/products/order-by-rating")
    .then(data=>{
        return data.json()
    }).then(result=>{
        renderProduct(result);
});

function renderProduct(data) {
    for (const p of data) {
        const productList = document.getElementById('productList');

        let div = document.createElement('div');
        div.className = "col-md-4";
        let br = document.createElement('br');
        let divCon = document.createElement('div');
        divCon.className = "container";
        let img = document.createElement('img');
        img.src = p.productPicture;
        img.width = 220;
        img.height = 200;
        let divTextLeft = document.createElement('div');
        let link = document.createElement('a');
        link.href = '/product_page';
        let pName = document.createElement('p');
        pName.innerText = p.name;
        let pPrice = document.createElement('p');
        pPrice.innerText = "price:" + p.productPrice;

        divCon.appendChild(img);
        link.appendChild(pName);
        divTextLeft.appendChild(link);
        divTextLeft.appendChild(pPrice);

        link.addEventListener('click', (e) => {
            localStorage.setItem('selectedProduct', p.id);
        })

        div.appendChild(br);
        div.appendChild(divCon);
        div.appendChild(divTextLeft);
        div.appendChild(br);

        productList.append(div);
    }
}




