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
        divTextLeft.className = "content-below";
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



function modal() {
    const news_body = document.getElementById('news_model_body');
    news_body.innerHTML = ``;
    fetch("http://localhost:9898/news")
        .then(date => {
            return date.json()
        }).then(result => {
        modal_body(result);
    });

    function modal_body(data) {
        for (const n of data) {

            let div = document.createElement('div');
            div.className = "col-md-4";
            let br = document.createElement('br');
            let divCon = document.createElement('div');
            divCon.className = "container";
            let img = document.createElement('img');
            img.src = n.news_picture;
            img.width = 220;
            img.height = 200;
            let divTextLeft = document.createElement('div');
            let link = document.createElement('a');
            link.href = '/product_page';
            let news_name = document.createElement('p');
            news_name.innerText = n.name;
            let news_price = document.createElement('p');
            news_price.innerText = "Price for beginning selling:  " + n.news_price;
            let news_detail = document.createElement('p');
            news_detail.innerText = "DETAIL: " + n.news_detail;
            let news = document.createElement('p');
            news.innerText = "News about new products: " + n.news;

            div.appendChild(img);
            div.appendChild(br);
            div.appendChild(divTextLeft);
            div.appendChild(news_name);
            div.appendChild(news_price);
            div.appendChild(news)

            news_body.append(div);
            console.log("sdfsdf")
            console.log(news_body);
        }

    }
}




