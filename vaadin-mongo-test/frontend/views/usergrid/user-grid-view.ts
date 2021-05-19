import { LitElement, html, css, customElement } from 'lit-element';

@customElement('user-grid-view')
export class UserGridView extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
      }
      `;
  }

  render() {
    return html`
<br>
<h3>Agiungi Utente</h3>
	<vaadin-form-layout id = "aggiungiUtenteForm"> 
	<vaadin-text-field id="username" label="username" type = "text" required></vaadin-text-field>
	<vaadin-password-field id="password" label="password" type = "password" required></vaadin-password-field>
	<vaadin-text-field id="name" label="name" type = "text" required></vaadin-text-field>
    <vaadin-integer-field id="eta" label="eta" type = "number" required></vaadin-integer-field>
</vaadin-form-layout>
<vaadin-button id = "aggiungiUtente">Aggiungi Utente</vaadin-button>
`;
  }
}
