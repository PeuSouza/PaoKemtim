const INDEX_PAGE = "index.html"; 

// x = XMLHttpRequest

function getListForno() { 
    const x = new XMLHttpRequest();
    const url = "http://localhost:8080/forno";
    x.open("get", url, true);
    x.onreadystatechange = function() {
      if (x.readyState === 4 && x.status === 200) {
        const listPao = JSON.parse(x.responseText);
        console.log(listPao)
        validateListPao(listPao);
      } else if (x.readyState === 4) {
        alert("Erro ao recuperar a lista de fornos.");
        location.href =INDEX_PAGE ;
      }
    };
    x.send();
  }

  function checkEmpty(listforno) {
    if (Object.entries(listforno).length === 0) {
      alert("Não existem fornos de pãeszinhos cadastrados.");
      location.href = INDEX_PAGE;
    } else {
      appendAllForno(listforno);
    }
  }
  function appendAllForno(listforno) {
    const div = document.getElementById("container");
    for (let index = 0; index < listforno.length; index++) {
      div.appendChild(createDiv(listforno[index]));
    }
  }

  function createDiv(forno) {
    const header = document.createElement("h2");
    header.textContent = `${forno.pao.tipo}`;
    
    const spanInicial = document.createElement("span");
    spanInicial.textContent = `Iníco: ${dateToTime(forno.Inicial)}`;
    
    const spanSaida = document.createElement("span");
    spanSaida.textContent = `Fim: ${dateToTime(forno.Saida)}`;
  
    const spanTimer = document.createElement("span");
    spanTimer.setAttribute("class", "Timer");
    spanTimer.setAttribute("data-Saida", `${forno.Saida}`);
  
    const div = document.createElement("div");
    div.setAttribute("class", "forno");
    div.appendChild(header);
    div.appendChild(spanInicial);
    div.appendChild(spanSaida);
    div.appendChild(spanTimer);
    
    return div;


  }

  function dateToTime(dateInMilliseconds) {
    const date = new Date(dateInMilliseconds);
    return date.toLocaleTimeString("pt-BR", { hour: "2-digit", minute: "2-digit" });
  }
  
  getListForno();
  
  
