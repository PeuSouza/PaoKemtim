
const INDEX_PAGE = "index.html"; 

// x = XMLHttpRequest

function getListPao() { 
    const x = new XMLHttpRequest();
    const url = "http://localhost:8080/pao";
    x.open("get", url, true);
    x.onreadystatechange = function() {
      if (x.readyState === 4 && x.status === 200) {
        const listPao = JSON.parse(x.responseText);
        console.log(listPao)
        validateListPao(listPao);
      } else if (x.readyState === 4) {
        alert("Erro ao recuperar a lista de paes.");
        location.href =INDEX_PAGE ;
      }
    };
    x.send();
  }
  
  //validando se tem pão cadastrado 
  function validateListPao(listPao) {
    if (listPao.length === 0) {
      alert("Nao existe paozinho cadastrado.");
      location.href = INDEX_PAGE;
    } else {
      appendAllPao(listPao);
    }
  }
  
  // atribuindo a lista de pães na fornada
  function appendAllPao(listPao) {
    let div = document.getElementById("container");
    for (let index = 0; index < listPao.length; index++) {
      const button = document.createElement("button");
      button.setAttribute("id", listPao[index].tipo);
      button.setAttribute("onclick", "postFornada(this)");
      button.textContent = listPao[index].tipo;
      div.appendChild(button);
    }
  }
  
  getListPao();