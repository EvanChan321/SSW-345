# needed for forward reference of Sale in Product,
# since Sale is not yet defined.
from __future__ import annotations
from typing import List

# forward reference used for class Sale
class Product:
    __lastSale: Sale = None
    __inventory = 0

    def __init__(self, inventory, sale: Sale):
        self.__lastSale = sale
        self.__inventory = inventory

    def setLastSale(self, lastSale: Sale):
        self.__lastSale = lastSale
   
    def addInventory(self, amount):
        self.__inventory += amount
    
    def removeInventory(self, amount):
        self.__inventory -= amount

    @property
    def getLastSale(self) -> Sale:
        return self.__lastSale

    def __getitem__(self, item):
        return self
    @property
    def getInventory(self) -> int: 
        return self.__inventory

# no forward reference needed since Product is defined
class Sale:
    __saleTimes = 0
    __productSold: List[Product] = None
    __saleNumber: int = 0

    def __init__(self, product: List[Product]):  #, saleNumber: int = 1):
        Sale.__saleTimes +=1
        self.__product = product
        for item in product:
            item.removeInventory(1)
        self.__saleNumber = Sale.__saleTimes
        for index, product in enumerate(product):
            product[index].setLastSale(self)

    def setProductsSold(self, productSold: List[Product]):
        self.__productSold = productSold

    @property
    def getSaleNumber(self) -> int:
        return self.__saleNumber


productOne = Product(4, sale=None)
productTwo = Product(3, sale=None)
print(f"Inventory before Sales: {productOne.getInventory}, {productTwo.getInventory}")

saleOne = Sale([productOne, productTwo])
saleTwo = Sale([productOne])
saleThree = Sale([productTwo])

print(f"{productOne.getLastSale.getSaleNumber}, {productTwo.getLastSale.getSaleNumber}")
print(f"Inventory after Sales: {productOne.getInventory}, {productTwo.getInventory}")
