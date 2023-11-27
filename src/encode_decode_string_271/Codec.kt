package encode_decode_string_271

class TrollCodec {
  // Encodes a list of strings to a single string.
  fun encode(strs: List<String>): String {
    var str = ""
    for (i in 0 until strs.size) {
      if (i == strs.size - 1) {
        str += strs[i]
      } else {
        str += strs[i] + "🤡"

      }
    }

    return str
  }

  // Decodes a single string to a list of strings.
  fun decode(s: String): List<String> {
    return s.split("🤡")
  }
}

class Codec {
  // Encodes a list of strings to a single string.
  fun encode(strs: List<String>): String {
    val str = StringBuilder()

    for (s in strs) {
      str.append(s.length)
      str.append(":")
      str.append(s)
    }

    return str.toString()
  }

  // Decodes a single string to a list of strings.
  fun decode(s: String): List<String> {
    var result = ArrayList<String>()

    var i = 0
    while (i < s.length) {
      var number = 0
      while (i < s.length && s[i] != ':') {
        number = number * 10 + (s[i] - '0')
        i++
      }

      if (s[i] == ':') {
        i++
      }

      result.add(s.substring(i until (i + number)))
      i += number

    }

    return result
  }
}

fun main() {
  val toSerialize = listOf("Patate Douce", "Carotte", "Choufleur")
  val result = Codec().decode(Codec().encode(toSerialize))

  println(result)
}