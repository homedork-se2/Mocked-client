describe('Make disco mode', () => {
    it('Presses disco button and checks if disco lamps are present', () => {
        cy.visit('http://127.0.0.1:8080')

        cy.get('body').then((body) => {
                cy.get('button[id="disco-button"]').click().then(() => {
                    cy.get('div[class="disco-lamps"]').should('be.visible');
                })
        });
    });
});

