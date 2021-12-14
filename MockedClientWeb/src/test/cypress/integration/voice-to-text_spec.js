describe('Voice to text activation', () => {
    it('Presses voice to text button and checks for listening', () => {
        cy.visit('http://127.0.0.1:8080')

        cy.get('body').then((body) => {
            cy.get('button[id="voiceButton"]').click().then(() => {
                cy.get('button[id="voiceButton"]').contains("Listening..")
            })
        });
    });
});