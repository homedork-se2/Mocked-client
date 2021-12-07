
describe('Connection check', () => {
    it('Visits the Game', () => {
        cy.visit('http://127.0.0.1:8080/game')

        cy.contains('game')

    })
})

describe('Image checks', () => {
    it('Checks for presence of character and stone image', () => {
        cy.get('div[class="game"]').find("img").should('be.visible');
    });
})
