
    const news_body = document.getElementById('news_model_body');
    news_body.innerHTML = ``;
    fetch("http://localhost:9898/news")
        .then(date => {
            return date.json()
        }).then(result => {
        modal_body(result);
        console.log(result);
        console.log(result.newsPrice);
    });

    function modal_body(data) {
        for (const n of data) {

            console.log(n.newsPrice);


          let main = `
          <div>
            <div>
                <img src="${n.newsPicture}">
                <p>${n.news}</p>
</div>
</div>
          `;

            news_body.innerHTML += main;
            console.log("sdfsdf");
            console.log(news_body);
        }
}