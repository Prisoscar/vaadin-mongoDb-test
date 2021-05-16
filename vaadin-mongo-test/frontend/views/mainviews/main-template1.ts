import '@vaadin/vaadin-button';
import '@vaadin/vaadin-text-field';
import { customElement, html, LitElement } from 'lit-element';

@customElement('main-template1')
export class MainTemplate1 extends LitElement {
  createRenderRoot() {
    // Do not use a shadow root
    return this;
  }

  render() {
    return html`<div id = "templateHeader">
                	<h1>Vaadin-Mongo-Test</h1>
                	<button id = "headerButton1">Header Button</button>
                </div>
                <div id = "actualPage">

                </div>
                <div id = "templateFooter">
                	<h2>Footer</h2>
                </div>`;
  }
}
