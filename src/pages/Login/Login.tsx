import { IonButton, IonContent, IonInput, IonItem, IonLabel, IonPage } from "@ionic/react"
import { useState } from "react";


const Login: React.FC=()=>{ 
    const [user,setUser]=useState('')
    const [pwd,setPwd]=useState('')

    const setToSession=(data:JSON)=> {
        
        sessionStorage.setItem("user", JSON.stringify(data));
        window.location.href="/home"
    }

    const handleClick=async (e: React.FormEvent)=>{
        e.preventDefault();

        if(user && pwd){
            var content = {
                method: "POST",
                headers: {
                  "Content-Type": "application/json",
                },
                body:""
            };
          
            content.body = JSON.stringify({
                'login': user,
                'mdp':pwd,
            });
            
            await fetch("http://localhost:8080/user/login", content)
            .then((response) => response.json())
            .then((json) => {
               if("error" in json)
                    alert("Mot de passe / identifiant non valide")
                else
                    setToSession(json.data);  
            });
        }
    }

    return <IonPage>
        <IonContent class="ion-padding">
        <h1>Login</h1>  
        <h2>identifiant = admin , password= admin</h2>
        <IonItem fill="outline">
            <IonLabel position="floating">Identifiant</IonLabel>
            <IonInput type="text" placeholder="Enter text" onIonChange={e => setUser(e.detail.value!)} ></IonInput>
        </IonItem>
        <br/>

        <IonItem fill="outline">
            <IonLabel position="floating">Password</IonLabel>
            <IonInput type="password" placeholder="Enter password" onIonChange={e => setPwd(e.detail.value!)}></IonInput>
        </IonItem>
        <br/>

        <IonButton fill="outline" onClick={handleClick}>Log in</IonButton>
        </IonContent>
    </IonPage>
}

export default Login