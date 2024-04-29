package com.tanjil.mywork.Data

import com.google.gson.JsonObject
import com.google.gson.JsonParser

class parseAddresee {
    companion object{
        fun getJson(vararg keys: String): List<String> {
            val gsonOBJECT: JsonObject? = JsonParser.parseString(jsonParser.json).asJsonObject
            var addresses: ArrayList<String> = arrayListOf("")
            if (keys.size == 3) {
                addresses.clear()
                gsonOBJECT?.getAsJsonArray(keys[0])?.forEach {
                    it.asJsonObject.getAsJsonArray(keys[1]).forEach {
                        it?.asJsonObject?.getAsJsonArray(keys[2])?.forEach {
                            addresses.add(it.toString())
                        }
                    }
                }
            }

            if (keys.size == 2) {
                addresses.clear()
                gsonOBJECT?.getAsJsonArray("বিভাগ")?.forEach {
                    it.asJsonObject.getAsJsonArray(keys[1]).forEach {
                        it.asJsonObject.keySet().forEach {
                            addresses.add(it)
                        }
                    }
                }
            }

            if (keys.size == 1) {
                addresses.clear()
                gsonOBJECT?.getAsJsonArray("বিভাগ")?.forEach {
                    it.asJsonObject.keySet().forEach {
                        addresses.add(it)
                    }
                }
            }

            return addresses
        }

    }



}