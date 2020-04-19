/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

let tab = document.querySelectorAll("a[data-target]")

tab.forEach(function(element) {
    element.addEventListener('click', function(e) {
        e.preventDefault();
        let url = this.href;
        let target = this.dataset.target
        fetch(url).then(function(response) {
            
            if(response.status === 200){
                response.text().then(function(response){
                    document.querySelector(target).parentNode.removeChild(document.querySelector(target))
                    alert(response)
                })
            }

        })

    })
})