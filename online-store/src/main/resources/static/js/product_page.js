let html_about_product;
let table2 = document.getElementById('productL');
let idEl = localStorage.getItem('selectedProduct');
let ratingIdTeg = document.getElementById('section-rating-id');
let url = `http://localhost:9898`;
let rating1 = 5;
let rating2;
let showReviews=document.getElementById("showReviews");
let pr="";

fetch("http://localhost:9898/rating/" + idEl)
    .then(response => {
        return response.json()
    })
    .then(rating => {
        // console.log("rating")
        // console.log(rating)
        rating1 = rating.rating * 20;

        rating2 = Math.round(rating.rating * 10) / 10;

    })

setTimeout(function () {
    fetch(`${url + '/products/getById/' + idEl}`, {
        method: 'GET',
    }).then(data => {
        return data.json();
    }).then((about_product) => {
        about_product.ratings.forEach(showReviews => {
            responseRating = `
                <div>
                    <div>
                     <div class="div-main-picture-class">
            <img src="${showReviews.user.profilePicture}" class="picture-class">
        </div>
        <div class="div-main-comment-class">
            <div class="user-name-over-comment">
                <p class="text-id">
                    ${showReviews.user.username}
                </p>
                <h6>:</h6>
                    ${showReviews.review}
</div>
</div>
            `;
            document.getElementById("list-review").innerHTML=responseRating;
        });


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
                        <p>Rating: ${rating2}</p>
                        <p class="ratings" style="background: linear-gradient(to right, green ${rating1}%, #919DA8 1%);"> &nbsp; 
    1 &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    2 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    3 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    4 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    5 &nbsp;</p>
                        </div>
                    </div>
`;

        $(document).ready(function () {
            $('#textarea-id').click(function () {
                var styles = {
                    height: "55px",
                    overflow: "hidden",
                    display: "block"
                };
                $('.btn-outer').slideDown();
                $('#textarea-id').css(styles);
            });
            $('#cancel-id').click(function () {
                $('.btn-outer').val('').slideUp();
                $('#textarea-id').css("height", "27px");
            });
        });
        var textarea = document.querySelector('textarea');
        textarea.addEventListener('keydown', autosize);

        function autosize() {
            var el = this;
            setTimeout(function () {
                el.style.cssText = 'height:auto; padding:0';
                el.style.cssText = 'height:' + el.scrollHeight + 'px';
            }, 0);
        }


        let productId = about_product.id;
        let userId = 0;
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

                });
                const invent = document.getElementById('invent-id');
                invent.addEventListener('submit', async function (e1) {
                    e1.preventDefault();
                    console.log('user id')
                    console.log(userId)
                    let reviewValue = document.getElementById("review").value;
                    await fetch(url + "/rating/" + 1, {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify({
                            rating: count,
                            review: reviewValue
                        })

                    });
                });
            });


        let commentList = document.getElementById('comment-list');
        let param = '';
        about_product.productComments.forEach(function (iter) {
            let fetchComments = `
<div class="div-one"">
    <div class="div-two">
        <div class="div-main-picture-class">
            <img src="${iter.user.profilePicture}" class="picture-class">
        </div>
        <div class="div-main-comment-class">
            <div class="user-name-over-comment">
                <p class="text-id">
                    ${iter.user.username}
                </p>
                <p class="date-id">${iter.date}</p>
            </div>
            <div class="comment-class">
            <p class="text-id">
                ${iter.comment}
            </p>
            </div>
            <div class="answer-for-comment">
                <p class="text-id">answer in thread</p>
            </div>
            <div class="comment-thread-class">
                <p class="text-id">threads</p>
            </div>
        </div>
        <div class="div-main-button-class">
                <div onclick="myFunction(${iter.id})" class="three-dots">
                
                    <figure class="figure-id"></figure>
                    <figure class="figure-id"></figure>
                    <figure class="figure-id"></figure>
              
                </div>
            <div class="update-delete-classes" id="${iter.id}">
                <div class="update-class-one">
                    <div>Edit</div>
                </div>
                <div class="delete-class-one">
                    <div>Remove</div>
                </div>
            </div>
        </div>
    </div>
</div>
`;

            param += fetchComments;
        });


        commentList.innerHTML = param;
        table2.innerHTML = html_about_product;
    });

}, 200)

function myFunction(event) {
    console.log("reached")
    let ev = document.getElementById(event);
    if (ev.style.display === "none") {
        ev.style.display = "block";
    } else {
        ev.style.display = "none";
    }
}

let count = 0;
let review = "";

function starmark(item) {
    count = item.id[0];
    sessionStorage.starRating = count;
    let subid = item.id.substring(1);
    console.log(count);
    for (let i = 0; i < 5; i++) {
        if (i < count) {
            document.getElementById((i + 1) + subid).style.color = "orange";
        } else {
            document.getElementById((i + 1) + subid).style.color = "grey";
        }
    }
}

// fetch('http://localhost:9898/rating/user/2')
//     .then(data => { return  data.json()})
//     .then(data =>{
//        console.log(data)
//        console.log(data.id)
//     }
// )
let o;
let haha1;

fetch('http://localhost:9898/rating/user2/2')
    .then(data => {
        console.log(data)
        return  data.json()})
    // .then(data =>{
    //         console.log(data)
    //         // console.log(data.)
    //         o = data;
    //         if (o){
    //             console.log("999")
    //
    //         }




haha1 = document.getElementById("formIdHa")

setTimeout(function (){

},100)
haha1.addEventListener('submit', function (e) {
    e.preventDefault()
    let a = document.getElementById("comment").value;

    fetch('http://localhost:9898/rating/' + idEl, {
        method: 'POST',
        body: JSON.stringify({
            rating: count,
            review: a
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(setTimeout(function () {
        document.location.href = 'http://localhost:9898/product_page'
    }, 100))
    // fetch("http://localhost:9898/rating/1")
    //     .then(response => {
    //         return response.json()
    //     })
    //     .then(rating => {
    //         console.log("rating")
    //         console.log(rating)
    //     })
    // fetch("http://localhost:9898/rating/getById/1")
    //     .then(response => {
    //        return   response.json()
    //     })
    //     .then(rating => {
    //         console.log("rating")
    //         console.log(rating)
    //     })
})





