let html_categories = ``;
let url = "http://localhost:9898/categories";
let tech = [];
let wMach = [];
let refr = [];
let tv = [];
let allCategories = [];
let el;
fetch(url).then(response => response.json()).then(categories => {
    categories.forEach((el) => {
        el.products.map(elo => {
            if (el.name === 'Technologies') {
                tech.push(elo);
            } else if (el.name === 'Washing Machines') {
                wMach.push(elo);
            } else if (el.name === 'Refrigerators') {
                refr.push(elo);
            } else if (el.name === 'TV') {
                tv.push(elo);
            }
            allCategories.push(elo)
        });
        html_categories += `<a href="#" onclick="return methodOne('${el.name}');" style="text-decoration: none;"> <li style="border-bottom: 1px solid dimgrey; padding: 5px 0">&nbsp;&nbsp; ${el.name}</li></a>`
    });
    html_categories += ` <a href="#" style="text-decoration: none;" onclick="return methodTwo();"><li>&nbsp;&nbsp;Все Категории</li></a>`;
    document.getElementById("categories").innerHTML = html_categories;
}).catch(err => {
    console.log(err)
})

function methodOne(nameO) {
    let t;
    if (nameO === 'TV') {
        const p = new Promise(function (resolve, reject) {
            let param = '';
            tv.forEach(function (iter) {
                t = ` <div class="col-md-4"> <div class="container"> <img src="${iter.productPicture}" style="width: 220px; height: 200px"> <a href="/product_page"><p>${iter.name}</p></a> <p>Price: ${iter.productPrice}</p> </div> </div> `;
                param += document.createElement('div').innerHTML = t;
            });
            resolve(param);
        });
        p.then(function (result) {
            document.getElementById('productList').innerHTML = result;
        });
    } else if (nameO === 'Technologies') {
        const p = new Promise(function (resolve, reject) {
            let param = '';
            tech.forEach(function (iter) {
                t = ` <div class="col-md-4"> <div class="container"> <img src="${iter.productPicture}" style="width: 220px; height: 200px"> <a href="/product_page"><p>${iter.name}</p></a> <p>Price: ${iter.productPrice}</p> </div> </div> `;
                param += document.createElement('div').innerHTML = t;
            });
            resolve(param);
        });
        p.then(function (result) {
            document.getElementById('productList').innerHTML = result;
        });
    } else if (nameO === 'Washing Machines') {
        const p = new Promise(function (resolve, reject) {
            let param = '';
            wMach.forEach(function (iter) {
                t = ` <div class="col-md-4"> <div class="container"> <img src="${iter.productPicture}" style="width: 220px; height: 200px"> <a href="/product_page"><p>${iter.name}</p></a> <p>Price: ${iter.productPrice}</p> </div> </div> `;
                param += document.createElement('div').innerHTML = t;
            });
            resolve(param);
        });
        p.then(function (result) {
            document.getElementById('productList').innerHTML = result;
        });
    } else if (nameO === 'Refrigerators') {
        const p = new Promise(function (resolve, reject) {
            let param = '';
            refr.forEach(function (iter) {
                t = ` <div class="col-md-4"> 
                        <div class="container">
                            <img src="${iter.productPicture}" style="width: 220px; height: 200px">
                                <a href="/product_page">
                                    <p>${iter.name}</p>
                                </a>
                                <p>Price: ${iter.productPrice}</p> 
                        </div>
                      </div> `;
                param += document.createElement('div').innerHTML = t;
            });
            resolve(param);
        });
        p.then(function (result) {
            document.getElementById('productList').innerHTML = result;
        });
    }
}

function methodTwo() {
    const p = new Promise(function (resolve, reject) {
        let param = '';
        allCategories.forEach(function (iter) {
            let t = ` <div class="col-md-4"> 
                        <div class="container">
                            <img src="${iter.productPicture}" style="width: 220px; height: 200px">
                                <a href="/product_page">
                                    <p>${iter.name}</p>
                                </a>
                                <p>Price: ${iter.productPrice}</p> 
                        </div> 
                      </div> `;
            param += document.createElement('div').innerHTML = t;
        });
        resolve(param);
    });
    p.then(function (result) {
        document.getElementById('productList').innerHTML = result;
    });
}