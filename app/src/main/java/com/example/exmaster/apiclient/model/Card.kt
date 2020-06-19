package com.example.exmaster.apiclient.model

// Um card
class Card (
    var name: String? = null,
    var manaCost: String? = null,
    var power: String? = null,
    var toughness: String? = null
)

// retorno
// { cards: [ card1, card2, ...] }


/*
[ ]
: list<object>

{ }
: object
 */