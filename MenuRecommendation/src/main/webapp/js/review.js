let cont = document.getElementById('review')
var click = 0
function revv(){
    click++;
    console.log(click)
    if(click%2 == 0) {
        cont.remove();       
    }else{
        cont.innerHTML += '<div class="innerReview">ㅈㅁㅌ~~</div>'
    }
}