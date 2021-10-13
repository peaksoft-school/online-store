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
function modal(){
    const stock_body = document.getElementById('stock_model_body');
    stock_body.innerHTML = ``;
    fetch("http://localhost:9898/stocks")
        .then(data=>{
            return data.json()
        }).then(result=>{
            modal_body(result);
    });

    function modal_body(data){
        for(const s of data){

            let div = document.createElement('div');
            div.className = "col-md-4";
            let br = document.createElement('br');
            let divCon = document.createElement('div');
            divCon.className = "container";
            let img = document.createElement('img');
            img.src = s.stock_picture;
            img.width = 220;
            img.height = 200;
            let divTextLeft = document.createElement('div');
            let link = document.createElement('a');
            link.href = '/product_page';
            let stock_name = document.createElement('p');
            stock_name.innerText = s.name;
            let stock_price = document.createElement('p');
            stock_price.innerText = "price:" + s.stock_price;
            let stock = document.createElement('p');
            stock.innerText ='Акция '+ s.stock+'%';

            div.appendChild(img);
            div.appendChild(br);
            div.appendChild(divTextLeft);
            div.appendChild(stock_name);
            div.appendChild(stock_price);
            div.appendChild(stock)

            stock_body.append(div);
        }

    }

}
