-- Shocky LUA script
local table = net.json(net.get("https://sessionserver.mojang.com/session/minecraft/profile/"..args))
local skin = table.properties[1]
print("skin blob")
print(skin.value)
print(" ")
print("signature")
print(skin.signature)
print(" ")
print("decoded")
print(factoid.base64decode(skin.value))

