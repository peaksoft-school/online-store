let html_about_product;
let table2 = document.getElementById('productL');
let idEl = localStorage.getItem('selectedProduct');
let ratingIdTeg = document.getElementById('section-rating-id');
let url = `http://localhost:9898`;
fetch(`${url + '/products/getById/'+ idEl}`, {
    method: 'GET',
}).then(data => {
    return data.json();
}).then((about_product) => {
    console.log("before")
    console.log(about_product.id)
    console.log("after")
    let count1 = 0;
    let avg = 0;
    about_product.ratings.forEach(function (response) {
        count1++;
        avg = avg + response.rating;
    });
    avg /= count1;
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
                        <p>Rating: ${avg}</p>
                        </div>
                    </div>
`;

    $(document).ready(function(){
        $('#textarea-id').click(function(){
            var styles = {
                height: "55px",
                overflow: "hidden",
                display: "block"
            };
            $('.btn-outer').slideDown();
            $('#textarea-id').css(styles);
        });
        $('#cancel-id').click(function (){
            $('.btn-outer').val('').slideUp();
            $('#textarea-id').css("height", "27px");
        });
    });
    var textarea = document.querySelector('textarea');
    textarea.addEventListener('keydown', autosize);
    function autosize(){
        var el = this;
        setTimeout(function(){
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
    console.log(about_product.id)
            console.log(userId)
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
    about_product.productComments.forEach(function (iter){
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

function starmark(item)
{
    count=item.id[0];
    sessionStorage.starRating = count;
    let subid= item.id.substring(1);
    for(let i=0;i<5;i++)
    {
        if(i<count)
        {
            document.getElementById((i+1)+subid).style.color="orange";
        }
        else
        {
            document.getElementById((i+1)+subid).style.color="grey";
        }
    }

}


