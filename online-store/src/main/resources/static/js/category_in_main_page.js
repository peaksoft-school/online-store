let html_categories = ``;
console.log("html_categories")

fetch("http://localhost:9898/categories")
    .then(response => {

        return response.json();
    }).then(categories => {
    html_categories += `<li><a style="color: black; font-family: Times New Roman, Times, serif" href="/main_page/phones">Phones</a>
                        <a style="color: black; font-family: Times New Roman, Times, serif" href="/main_page/laptops">Laptops</a>
                        <a style="color: black; font-family: Times New Roman, Times, serif" href="/main_page/fridges">Fridges</a>
                        <a style="color: black; font-family: Times New Roman, Times, serif" href="/main_page/televisions">Televisions</a> 
                        <a style="color: black; font-family: Times New Roman, Times, serif" href="/main_page/washMachines">Wash Machines</a>
                        </li>                     
                        `
    html_categories += ` <hr>
 <li class="divider"></li>
                        <li><a style="color: black; font-family: Times New Roman, Times, serif" href="/main_page/products">&nbsp;&nbsp;Все категории</a></li>`;
    console.log(html_categories)
    document.getElementById("categories").innerHTML = html_categories;

}).catch(err => {
    console.log(err)
})
