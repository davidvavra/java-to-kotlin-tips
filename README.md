# java-to-kotlin-tips
Android app which shows tips &amp; tricks how to convert Java to Kotlin. From a talk at DevFest Siberia 2017. If you follow the instructions you can use it as a codelab. See the correct solution in the 'solution' branch.

Inspiration for this talk was from (this blogpost)[https://android.jlelse.eu/how-to-remove-all-from-your-kotlin-code-87dc2c9767fb].

## Instructions
  - Add Kotlin support to the project
  - Convert just `Model` class to Kotlin, make sure the app works with one Java and one Kotlin class
  - Simplify `Model` class using data class, make name parameter non-nullable
  - Convert `MainActivity` to Kotlin
  - Add plugin 'kotlin-android-extensions', remove `findViewById` and related !!
  - Make `mModel` lateinit and remove related !!
  - Replace the first null check in `showData()` with `?.let` function and remove related !!
  - Replace second null check there with custom function `ifNotNull(first, second, bothNotNull: lambda)`
  - Move this function into `Extensions.kt` file and also create an extension `View.show()` there instead of setting visibility in the `MainActivity`
  - Simplify `updateBottomText()` with the elvis operator
  - Remove last !! on mGithubUrl with crashing on your own terms using `checkNotNull` function
  - Run the app and make sure everything works
  
## Optional: Anko
  - Add anko dependency to gradle
  - Try logging with Anko
  - Create an alert dialog with Anko with title, positive and negative button
  - When positive button is clicked, show a toast with Anko
  - When negative button is clicked, send an email with Anko
