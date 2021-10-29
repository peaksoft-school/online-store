const news_body = document.getElementById('news_model_body');
news_body.innerHTML = ``;
fetch("http://localhost:9898/news")
    .then(date => {
        return date.json()
    }).then(result => {
    modal_body(result);
    console.log(result);
});

function modal_body(data) {
    for (const n of data) {
        let main = `
          <div>
            <div>
            <p style="margin-left: 5%">${n.news}</p> 
            <p ><b>Model: </b>${n.name}</p>
                <img src="${n.newsPicture}" alt="" width="350" height="350">
                <p><b>News Detail's: </b>${n.newsDetail}</p>
                <p><b>Price: </b>${n.newsPrice}<b> KGS</b></p>
                <p><b>Active from: </b>${n.newsTime}</p>               
</div>
</div>

          `;

        news_body.innerHTML += main;
        console.log(news_body);
    }
}