/*TAD Arbol binario
ESTRUCTURAS DE DATOS 1CM7
ABRIL 2017
*/
#include <stdio.h>
#include <stdlib.h>
#include "TADArbolBin.h"

/*recibe<-árbol(A); 
Initialize (A)
Efecto: Recibe un árbol binario A y lo inicializa para su trabajo normal.
*/
void Initialize(arbol_bin *A){
	*A = NULL;
	return;
}

/*recibe<-árbol(A); 
Destroy (A)
Efecto: Recibe un árbol binario A y lo libera completamente.
*/
void Destroy(arbol_bin *A){
	if(*A == NULL)
		return;
	else
	{
		if((*A)->izq != NULL)
			Destroy(&((*A)->izq));
		if((*A)->der != NULL)
			Destroy(&((*A)->der));
		free(*A);
		return;
	}
}

/*recibe<-árbol(A); retorna -> posición
Root (A)
Efecto: Recibe un árbol binario A y retorna la posición de la raíz de A, si el árbol es vacío devuelve una posición nula.
*/
posicion Root(arbol_bin *A){
	return *A;
}


/*recibe<-árbol(A), posición(P); retorna -> posición
Parent(A,P)
Efecto: Recibe un árbol binario  A y una posición P, devuelve la posición de padre de p. 
Requerimientos: El árbol binario A es no vacío y la posición P es una posición valida. Si P es la raíz se devuelve una posición nula.
*/
posicion Parent(arbol_bin *A, posicion p){
	posicion r = NULL;
	if(*A == NULL || *A == p)
		return NULL;
	else if ((*A)->izq == p || (*A)->der == p)
		return *A;
	else 
	{
		r = Parent(&((*A)->izq), p);
		if(r == NULL)
			r = Parent(&((*A)->der), p);
		return r;
	}
}

/*recibe<-árbol(A), posición(P); retorna -> posición
RightSon(A,P)
Efecto: Recibe un árbol binario A y una posición P, devuelve la posición del hijo derecho de p. 
Requerimientos: El árbol binario A es no vacío y la posición P es una posición valida. Si P no tiene hijo derecho devuelve una posición nula.
*/
posicion RightSon(arbol_bin *A, posicion P)
{
	posicion r = NULL;
	if(!NullNode(A, P))
		r = P -> der;
	
	return r;
}
/*recibe<-árbol(A), posición(P); retorna -> posición
LeftSon(A,P)
Efecto: Recibe un árbol binario A y una posición P, devuelve la posición del hijo izquierdo de p. 
Requerimientos: El árbol A es no vacío y la posición P es una posición valida. Si P no tiene hijo izquierdo devuelve una posición nula.
*/
posicion LeftSon(arbol_bin *A, posicion P)
{
	posicion r = NULL;
	if(!NullNode(A, P))
		r = P -> izq;
	
	return r;
}


/*recibe<-árbol(A), elemento (E); retorna -> posición
Search(A,E)
Efecto: Recibe un árbol binario A y un elemento E, devuelve la posición del elemento E en el árbol  A.
Requerimientos: El árbol binario A es no vacío y la posición P es una posición valida. Si E no es encontrado devuelve una posición nula.
*/
posicion Search(arbol_bin *A, char character)
{
	
	posicion r = NULL;
	if(*A == NULL)
		return NULL;
	else if ((*A)->e.character == character)
		return *A;
	else 
	{
		r = Search(&((*A)->izq), character);
		if(r == NULL)
			r = Search(&((*A)->der), character);
		return r;
	}

}

/*recibe<-árbol(A); retorna -> booleano
Empty(A)
Efecto: Recibe un árbol binario A y devuelve verdadero en caso de que el árbol A este vacío, devuelve falso en caso contrario.
*/
boolean Empty(arbol_bin *A)
{
	boolean r;
	if(*A == NULL)
		r = TRUE;
	else 
		r = FALSE;
	
	return r;
}

/*recibe<-árbol(A), posición (P); retorna -> booleano
NullNode(A,P)
Efecto: Recibe un árbol binario A y una posición P, devuelve verdadero si la posición P del árbol A es nula o incorrecta y devuelve falso en caso contrario.
*/
boolean NullNode(arbol_bin *A, posicion p)
{
	boolean r;
	if(*A == NULL)
		return TRUE;
	else if (*A == p)
		return FALSE;	
	
	else 
	{
		r = NullNode(&((*A)->izq), p);
		if(r == TRUE)
			r = NullNode(&((*A)->der), p);
		return r;
	}
}

/*recibe<-árbol(A), posición (P); retorna -> elemento
ReadNode(A,P)
Efecto: Recibe un árbol binario A y una posición P, devuelve el elemento en la posición P del árbol A.
Requerimientos: El árbol A es no vacío y la posición P es una posición valida..
*/
elemento ReadNode(arbol_bin *A, posicion p)
{
	elemento r;
	
	if(!NullNode(A, p)){
		r = p->e;
	}
	else
	{
		printf("Error: ReadNode");
		exit(1);
	}
	
	return r;
}

/*recibe<-árbol(A), posición (P), elemento E; 
NewRightSon(A,P,E)
Efecto: Recibe un árbol binario A, una posición P y un elemento E, se añade un nodo que contenga E como hijo derecho del nodo con posición P.
Requerimientos: El árbol binario A es no vacío y la posición P es una posición valida. Si el árbol A es vacío se agrega a un nodo raíz con E. si P ya tiene un hijo derecho, se cancela la operación.
*/
void NewRightSon(arbol_bin *A, posicion p, elemento e)
{
	if(Empty(A))
	{
		*A = malloc(sizeof(nodo));
		(*A)->e = e;
		(*A)->izq = NULL;
		(*A)->der = NULL;
	}
	else if(!NullNode(A, p))
	{
		if(p->der != NULL){
			printf("Error: NewRightSon: ya existe");
			exit(1);
		}
		else
		{
			p->der = malloc(sizeof(nodo));
			p->der->e = e;
			p->der->izq = NULL;
			p->der->der = NULL;
		}
	}else{
		printf("Error: NewRightSon");
		exit(1);
	}
	return;
}

/*recibe<-árbol(A), posición (P), elemento E; 
NewLeftSon(A,P,E)
Efecto: Recibe un árbol binario A, una posición P y un elemento E, se añade un nodo que contenga E como hijo izquierdo del nodo con posición P.
Requerimientos: El árbol binario A es no vacío y la posición P es una posición valida. Si el árbol A es vacío se agrega a un nodo raíz con E; si P ya tiene un hijo Izquierdo, se cancela la operación.
*/
void NewLeftSon(arbol_bin *A, posicion p, elemento e)
{
	if(Empty(A))
	{
		*A = malloc(sizeof(nodo));
		(*A)->e = e;
		(*A)->izq = NULL;
		(*A)->der = NULL;
	}
	else if(!NullNode(A, p))
	{
		if(p->izq != NULL){
			printf("Error: NewLeftSon: ya existe");
			exit(1);
		}
		else
		{
			p->izq = malloc(sizeof(nodo));
			p->izq->e = e;
			p->izq->izq = NULL;
			p->izq->der = NULL;
		}
	}else{
		printf("Error: NewLeftSon");
		exit(1);
	}
	return;
}

/*recibe<-árbol(A), posición (P);
DeleteRightSon(A,P)
Efecto: Recibe un árbol binario A y una posición se elimina al hijo derecho y todos sus descendientes del nodo con posición P.
Requerimientos: El árbol A es no vacío y la posición P es una posición valida y tiene un hijo derecho.
*/
void DeleteRightSon(arbol_bin *A, posicion p)
{
	if(!NullNode(A, p))
	{
		Destroy(&(p->der));
	}
	else
	{
		printf("Error: DeleteRightSon");
		exit(1);
	}
	return;
}

/*recibe<-árbol(A), posición (P);
DeleteLeftSon(A,P)
Efecto: Recibe un árbol binario A y una posición se elimina al hijo izquierdo y todos sus descendientes del nodo con posición P.
Requerimientos: El árbol A es no vacío y la posición P es una posición valida y tiene un hijo izquierdo.
*/
void DeleteLeftSon(arbol_bin *A, posicion p)
{
	if(!NullNode(A, p))
	{
	Destroy(&(p->izq));
	}
	else
	{
		printf("Error: DeleteLeftSon");
		exit(1);
	}
}
/*recibe<-árbol(A), posición (P);
	}
	return;
}
DeleteNode(A,P)
Efecto: Recibe un árbol binario A y una posición P, se elimina al nodo con posición  P  y todos sus descendientes.
Requerimientos: El árbol A es no vacío y la posición P es una posición valida. 
*/
void DeleteNode(arbol_bin *A, posicion p)
{
	if(!NullNode(A, p))
	{
		Destroy(&p);
	}
	else
	{
		printf("Error: Delete");
		exit(1);
	}
	return;
}

/*recibe<-árbol(A), posición (P), elemento (E);
ReplaceNode(A,P)
Efecto: Recibe un árbol binario A, una posición P y un elemento E, se remplaza a E del nodo con posición P en A.
Requerimientos: El árbol binario A es no vacío y la posición P es una posición valida. 
*/
void ReplaceNode(arbol_bin *A, posicion p, elemento e)
{
	if(!NullNode(A, p))
	{
		p->e = e;
	}
	else
	{
		printf("Error: ReplaceNode");
		exit(1);
	}
	return; 
}

/*recibe<-*árbol(rootTree), arbol (sonTree), int (place);
Efecto: Une dos arboles, rootTree sera la raiz del arbol union, y sonTree sera el hijo izquierdo(0) o derecho(1) 
dependiendo del valor de place(0-1). 
*/
void linkTrees(arbol_bin *rootTree, arbol_bin sonTree, int place){
	/*Insertar a la izquierda*/
	if(place == 0){
		(*rootTree)->izq = sonTree;
	/*Insertar a la derecha*/
	}else if(place == 1){
		(*rootTree)->der = sonTree;
	}else{
		printf("\nError: Place not found");
	}
	return;	
}

/*recibe<arbol_bin *A, int place, int value;
Recibe un arbol y cambia el codigo de huffamn de todos los elementos del arbol.
*/
void ReplaceCodeALL(arbol_bin *A, int place, int value){
	if(*A == NULL)
		return;
	else
	{
		if((*A)->izq != NULL || (*A)->der != NULL)
			place++;
		if((*A)->izq != NULL)
			ReplaceCodeALL(&((*A)->izq), place, value);
		if((*A)->der != NULL)
			ReplaceCodeALL(&((*A)->der), place, value);
		if (value == 0){
			PONE_0((*A)->e.huffmanCode.code, place);
			(*A)->e.huffmanCode.n_bits++;
		}
		else if(value == 1){
			PONE_1((*A)->e.huffmanCode.code, place);
			(*A)->e.huffmanCode.n_bits++;		
		}
		else printf("\nError: ReplaceCodeALL");
		place--;
		return;
	}
}

/*recibe<-arbol_bin *A;
ReplaceNode(A,P)
Efecto: Inicializa las variables necesesarias para el algoritmo de huffman. 
*/
void PrepareTreeForHuffman(arbol_bin *A){
	if(*A == NULL)
		return;
	else
	{
		if((*A)->izq != NULL)
			PrepareTreeForHuffman(&((*A)->izq));
		if((*A)->der != NULL)
			PrepareTreeForHuffman(&((*A)->der));
		(*A)->e.huffmanCode.code = 0;
		(*A)->e.huffmanCode.n_bits = 0;
		return;
	}
}

void ReplaceNodeTree(arbol_bin *A, elemento e)
{
	if((*A)!=NULL)
	{
		(*A)->e = e;
	}
	else
	{
		printf("Error: ReplaceNodeTree");
		exit(1);
	}
	return; 
}