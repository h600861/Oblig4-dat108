
   function sjekkPassordStyrke() {
        const a = getElement("passord")

        if (a) {
            a.addEventListener("input", checkValidity);

            function checkValidity() {
                const validity = a.validity;
                if (validity.valid) {
                    const value = a.value;

                    if (value.length >= 8 && value.length<12) {
                        a.classList.add("mediumPassword");
                    } else {
                        a.classList.remove("mediumPassword");
                    }
                }
            }
            return () => a.removeEventListener("input", checkValidity);
        }

    }

    function sammenlignPassord(){
    const pass = getElement("passord")
    const repetertPass = getElement("passordRepetert")

        if(pass && repetertPass) {
            pass.addEventListener("input",sammenlign );
            repetertPass.addEventListener("input", sammenlign);

            function sammenlign(){
                if (pass.value === repetertPass.value) {
                    repetertPass.setCustomValidity("");
                } else {
                    repetertPass.setCustomValidity("Repetert passord er feil")
                }
            }
            return () => {
                pass.removeEventListener("input", sammenlign);
                repetertPass.removeEventListener("input", sammenlign);
            }
            }

        }
    function getElement(name) {
        return document.getElementById("deltagerFormBean").querySelector(`input[name=${name}]`);

    }
