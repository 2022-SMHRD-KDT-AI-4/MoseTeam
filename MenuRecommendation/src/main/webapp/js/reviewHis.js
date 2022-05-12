let cont1 = document.getElementById('review1')
var click1 = 0
function revv1(){
    click1++;
    console.log(click1)
    if(click1%2 == 0) {
       $('#review1').empty();       
    }else{
        cont1.innerHTML += '<div class="innerReview">ㅈㅁㅌ~~</div> <br><br>'
    }
}
let cont2 = document.getElementById('review2')
var click2 = 0
function revv2(){
    click2++;
    console.log(click2)
    if(click2%2 == 0) {
       $('#review2').empty();       
    }else{
        cont2.innerHTML += '<div class="innerReview">치즈 계란찜 JMTGR~</div> <br><br>'
    }
}