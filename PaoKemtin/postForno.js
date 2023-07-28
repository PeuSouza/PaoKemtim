function postForno(button) {
    const x = new XMLHttpRequest();
    const url = "http://localhost:8080/forno/{codigo}" + button.codigo;
    x.open("post", url, true);
    x.setRequestHeader("Content-Type", "application/json");
    x.onreadystatechange = function() {
      if (x.readyState === 4 && x.status === 200) {
        alert("Fornada cadastrada com sucesso.");
      } else if (x.readyState === 4) {
        alert("Erro ao cadastrar a fornada.");
      }
    };
    x.send(JSON.stringify({})); 
  }