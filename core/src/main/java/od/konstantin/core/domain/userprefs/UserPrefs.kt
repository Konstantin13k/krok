package od.konstantin.core.domain.userprefs

import od.konstantin.core.domain.models.Exam
import od.konstantin.core.domain.models.ExamLanguage
import od.konstantin.core.domain.models.Specialization

interface UserPrefs {

    var userSpecialization: Specialization?

    var userExam: Exam?

    var examLanguage: ExamLanguage?

    fun deleteAllPrefs()
}