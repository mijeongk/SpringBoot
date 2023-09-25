const myTag = document.querySelector('#today');
const target = document.querySelector('#tomorrow')
myTag.append(target.children[1]); // tomorrow의 1번 익덱스가 today의 맨 뒤에 추가된다
target.children[0].after(myTag.children[1]); // today의 1번 인덱스가 tomorrow의 0번
												// 인덱스 뒤에 추가된다.
