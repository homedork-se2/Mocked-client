
describe('Connection check', () => {
    it('Visits the status pane', () => {
        cy.visit('http://127.0.0.1:8080')

        cy.get('a[href*="status.jsp"]').contains('Personalized Status Commands').click()

    })
})

describe('Div checks', () => {
    it('Checks for presence of mood divs', () => {
        cy.get('div[class="rectangle"]').find("p").should('be.visible');
    });
})
