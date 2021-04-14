package od.konstantin.feature_home

sealed class TestType {
    object Booklets : TestType()
    object Bases : TestType()
    object DifficultQuestions : TestType()
    object UnfinishedQuestions : TestType()

    companion object {
        fun getList(): List<TestType> {
            return arrayListOf(
                Booklets,
                Bases,
                DifficultQuestions,
                UnfinishedQuestions
            )
        }
    }
}
