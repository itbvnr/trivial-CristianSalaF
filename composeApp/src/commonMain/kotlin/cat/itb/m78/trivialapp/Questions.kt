package cat.itb.m78.trivialapp

data class Question(
    val question: String,
    val answers: List<String>,
    val correctAnswerIndex: Int
)

enum class TrivialSubject {
    Kotlin,
    Html,
    Videojocs
}

object QuestionRepository {
    private val kotlinQuestions = listOf(
        Question(
            "Quin és el constructor principal a Kotlin?",
            listOf(
                "Constructor definit a la capçalera de la classe",
                "Primer constructor del cos de la classe",
                "Últim constructor del cos de la classe",
                "No hi ha tal cosa"
            ),
            0
        ),
        Question(
            "Quina paraula clau s'utilitza per declarar una variable que es pot canviar?",
            listOf("val", "var", "const", "let"),
            1
        ),
        Question(
            "Quin és el tipus d'operador de seguretat nul '?.' ?",
            listOf(
                "Operador de trucada segura",
                "Operador Elvis",
                "Afirmació no nul·la",
                "Operador de comprovació nul"
            ),
            0
        ),
        Question(
            "Què substitueix 'when' de Java?",
            listOf(
                "declaració if",
                "declaració switch",
                "bucle for",
                "bucle while"
            ),
            1
        ),
        Question(
            "Quina d'aquestes és una característica de classe de dades de Kotlin?",
            listOf(
                "Es requereix la implementació manual d'equals()",
                "Sense mètode toString()",
                "Funcions componentN() automàtiques",
                "No es pot heretar"
            ),
            2
        ),
        Question(
            "Quin és l'objectiu de la declaració 'object'?",
            listOf(
                "Crear múltiples instàncies",
                "Declarar singleton",
                "Definir la interfície",
                "Crea una classe abstracta"
            ),
            1
        ),
        Question(
            "Què és una corrutina a Kotlin?",
            listOf(
                "Un tipus de variable",
                "Un fil lleuger",
                "Una estructura de dades",
                "Un patró de disseny"
            ),
            1
        ),
        Question(
            "Quina funció s'utilitza per convertir de String nul a Int?",
            listOf(
                "toInt()",
                "parseInt()",
                "toIntOrNull()",
                "convertToInt()"
            ),
            2
        ),
        Question(
            "Quina diferència hi ha entre 'val' i 'const'?",
            listOf(
                "No hi ha diferència",
                "const és constant de temps d'execució, val és temps de compilació",
                "val és constant de temps d'execució, const és temps de compilació",
                "const es pot canviar, val no"
            ),
            2
        ),
        Question(
            "Quin és el propòsit del bloc 'init'?",
            listOf(
                "Inicialitza variables locals",
                "Inicialitza el constructor principal",
                "Executar la lògica d'inicialització",
                "Crear mètodes estàtics"
            ),
            2
        ),
        Question(
            "Què és una funció d'ordre superior a Kotlin?",
            listOf(
                "Una funció que no retorna res",
                "Una funció que pren o retorna una altra funció",
                "Una funció amb múltiples paràmetres",
                "Una funció que no es pot anul·lar"
            ),
            1
        ),
        Question(
            "Quin és el propòsit de la funció d'abast 'apply'.?",
            listOf(
                "Per executar un bloc de codi en un objecte i retornar el resultat",
                "Per executar un bloc de codi en un objecte i retornar l'objecte en si",
                "Per comprovar si un objecte és nul",
                "Per crear una nova instància d'un objecte"
            ),
            1
        ),
        Question(
            "Quina diferència hi ha entre 'ArrayList' i 'Array' a Kotlin?",
            listOf(
                "No hi ha diferència",
                "ArrayList és mutable, Array és immutable",
                "ArrayList té una mida dinàmica, Array té una mida fixa",
                "ArrayList és més ràpid que Array"
            ),
            2
        ),
        Question(
            "Quina és la finalitat del delegat 'by lazy'?",
            listOf(
                "Per fer que una propietat sigui nul·la",
                "Per inicialitzar una propietat només en el primer accés",
                "Per crear un valor constant",
                "Per fer una propietat privada"
            ),
            1
        ),
        Question(
            "Què és la interpolació de cadenes a Kotlin?",
            listOf(
                "Concatenació de cadenes amb '+'",
                "Fer servir expressions de plantilla amb '$'",
                "S'està convertint la cadena en majúscules",
                "Divisió de cadenes en matrius"
            ),
            1
        )
    )

    private val htmlQuestions = listOf(
        Question(
            "Què significa HTML?",
            listOf(
                "Hyper Text Markup Language",
                "High Tech Modern Language",
                "Hyper Transfer Markup Language",
                "Hybrid Text Memory Language"
            ),
            0
        ),
        Question(
            "Quina etiqueta s'utilitza per crear un hyperlink?",
            listOf("<link>", "<a>", "<href>", "<url>"),
            1
        ),
        Question(
            "Quin element HTML s'utilitza per crear un paràgraf?",
            listOf("<paragraph>", "<p>", "<para>", "<text>"),
            1
        ),
        Question(
            "Quin és l'element HTML correcte per inserir un salt de línia?",
            listOf("<break>", "<lb>", "<br>", "<newline>"),
            2
        ),
        Question(
            "Quin atribut HTML especifica un text alternatiu per a una imatge?",
            listOf("title", "alt", "description", "text"),
            1
        ),
        Question(
            "Quin és l'HTML correcte per crear una casella de selecció?",
            listOf(
                "<input type='check'>",
                "<checkbox>",
                "<input type='checkbox'>",
                "<box type='check'>"
            ),
            2
        ),
        Question(
            "Quin element HTML defineix el títol d'un document?",
            listOf("<meta>", "<head>", "<header>", "<title>"),
            3
        ),
        Question(
            "Quin és l'HTML correcte per fer una llista desplegable?",
            listOf("<list>", "<select>", "<input type='dropdown'>", "<dropdown>"),
            1
        ),
        Question(
            "Quin element HTML s'utilitza per especificar un peu de pàgina d'un document?",
            listOf("<bottom>", "<footer>", "<end>", "<section>"),
            1
        ),
        Question(
            "Quin és l'HTML correcte per inserir una imatge?",
            listOf(
                "<img href='image.jpg'>",
                "<image src='image.jpg'>",
                "<img src='image.jpg'>",
                "<picture src='image.jpg'>"
            ),
            2
        ),
        Question(
            "Quin és el propòsit de l'element HTML 'canvas'?",
            listOf(
                "Per mostrar imatges",
                "Per crear formularis",
                "Per dibuixar gràfics mitjançant scripts",
                "Per estilitzar el text"
            ),
            2
        ),
        Question(
            "Quin element HTML5 s'utilitza per reproduir fitxers de vídeo?",
            listOf(
                "<media>",
                "<player>",
                "<video>",
                "<movie>"
            ),
            2
        ),
        Question(
            "Quina és la manera correcta de crear una capçalera de taula HTML?",
            listOf(
                "<thead>",
                "<header>",
                "<th>",
                "<tableheader>"
            ),
            0
        ),
        Question(
            "Quin atribut HTML s'utilitza per especificar estils 'inline'?",
            listOf(
                "class",
                "styles",
                "style",
                "css"
            ),
            2
        ),
        Question(
            "Quin és l'objectiu de l'etiqueta HTML 'meta' del tag de viewport?",
            listOf(
                "Per definir paraules clau de la pàgina",
                "Per controlar el disseny als navegadors mòbils",
                "Per definir el títol de la pàgina",
                "Per definir la descripció de la pàgina"
            ),
            1
        )
    )

    private val videoGamesQuestions = listOf(
        Question(
            "Quina consola de videojocs es va llançar primer?",
            listOf(
                "Nintendo Entertainment System (NES)",
                "Atari 2600",
                "Sega Genesis",
                "PlayStation"
            ),
            1
        ),
        Question(
            "Qui és el company dinosaure de Mario?",
            listOf(
                "Bowser",
                "Yoshi",
                "Koopa",
                "Rex"
            ),
            1
        ),
        Question(
            "Quin és el videojoc més venut de tots els temps?",
            listOf(
                "Minecraft",
                "Tetris",
                "Grand Theft Auto V",
                "Wii Sports"
            ),
            0
        ),
        Question(
            "Quina empresa va crear Sonic the Hedgehog?",
            listOf(
                "Nintendo",
                "Sony",
                "Sega",
                "Capcom"
            ),
            2
        ),
        Question(
            "Quin va ser el primer joc amb Mario?",
            listOf(
                "Super Mario Bros",
                "Mario Bros",
                "Donkey Kong",
                "Mario's Cement Factory"
            ),
            2
        ),
        Question(
            "Quin d'aquests NO és un Pokémon dels 151 originals?",
            listOf(
                "Mewtwo",
                "Pikachu",
                "Lucario",
                "Gengar"
            ),
            2
        ),
        Question(
            "Quin any es va llançar la primera PlayStation?",
            listOf(
                "1991",
                "1994",
                "1995",
                "1996"
            ),
            1
        ),
        Question(
            "Quina franquícia de jocs inclou un personatge anomenat Master Chief?",
            listOf(
                "Doom",
                "Halo",
                "Gears of War",
                "Half-Life"
            ),
            1
        ),
        Question(
            "De quin color és la forma vulnerable dels fantasmes de Pac-Man?",
            listOf(
                "Blanc",
                "Blau",
                "Gris",
                "Vermell"
            ),
            1
        ),
        Question(
            "Quina empresa desenvolupa la sèrie Final Fantasy?",
            listOf(
                "Capcom",
                "Square Enix",
                "Konami",
                "Bandai Namco"
            ),
            1
        ),
        Question(
            "Què significa NPC als jocs?",
            listOf(
                "New Player Character",
                "Non-Playable Character",
                "Next Primary Character",
                "New Program Content"
            ),
            1
        ),
        Question(
            "Quin joc va introduir el gènere Battle Royale als jocs convencionals?",
            listOf(
                "Fortnite",
                "PUBG",
                "H1Z1",
                "Apex Legends"
            ),
            1
        ),
        Question(
            "Quin va ser el primer videojoc que es va presentar 'Easter Eggs'?",
            listOf(
                "Pac-Man",
                "Adventure",
                "Super Mario Bros",
                "Space Invaders"
            ),
            1
        ),
        Question(
            "Quina d'aquestes NO es una classe de personatge a World of Warcraft?",
            listOf(
                "Guerrer",
                "Mag",
                "Assassí",
                "Sacerdot"
            ),
            2
        ),
        Question(
            "Quina empresa es la propietaria de la franquícia Portal?",
            listOf(
                "Electronic Arts",
                "Valve",
                "Bethesda",
                "Activision"
            ),
            1
        )
    )

    fun getRandomQuestions(subject: TrivialSubject, count: Int): List<Question> {
        val questions = when (subject) {
            TrivialSubject.Kotlin -> kotlinQuestions
            TrivialSubject.Html -> htmlQuestions
            TrivialSubject.Videojocs -> videoGamesQuestions
        }
        return questions.shuffled().take(count)
    }
}