


let html_categories = ``;
console.log("html_categories")

fetch("http://localhost:9898/categories")
    .then(response => {

        return response.json();
    }).then(categories => {
    categories.forEach((el, id) => {
        html_categories += ` <li><a href="#">&nbsp; ${el.name}</a></li>`

    })

    html_categories += ` <li class="divider"></li>
                        <li><a href="#"> Все категории</a></li>`;
    console.log(html_categories)
    document.getElementById("categories").innerHTML = html_categories;

}).catch(err => {
    console.log(err)
})
