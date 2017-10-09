// spec.js
describe('Protractor Test App', function() {
  it('should add one and two', function() {
    browser.get('http://localhost:8087/index.html#/');

    element(by.cssContainingText('type', 'Telefone')).click();
    element(by.cssContainingText('type', 'Telefone')).click();
    element(by.cssContainingText('type', 'Telefone')).click();

    element(by.model('detalhes')).sendKeys("Teste detalhes");

    element(by.id('submit')).click();

    expect(element(by.binding('success_message')).getText()).
        toEqual('Success'); 

    element(by.id('rel')).click();

    var list = element.all(by.repeater('call in calls'));

    expect(list.count()).toEqual(12);

    
  });
});