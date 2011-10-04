package com.github.grailsbaseballscoreboard



import org.junit.*
import grails.test.mixin.*


@TestFor(TeamController)
@Mock(Team)
class TeamControllerTests {


    @Test
    void testIndex() {
        controller.index()
        assert "/team/list" == response.redirectedUrl
    }

    @Test
    void testList() {

        def model = controller.list()

        assert model.teamInstanceList.size() == 0
        assert model.teamInstanceTotal == 0

    }

    @Test
    void testCreate() {
       def model = controller.create()

       assert model.teamInstance != null


    }

    @Test
    void testSave() {
        controller.save()

        assert model.teamInstance != null
        assert view == '/team/create'

        // TODO: Populate valid properties

        controller.save()

        assert response.redirectedUrl == '/team/show/1'
        assert controller.flash.message != null
        assert Team.count() == 1
    }


    @Test
    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/team/list'


        def team = new Team()

        // TODO: populate domain properties

        assert team.save() != null

        params.id = team.id

        def model = controller.show()

        assert model.teamInstance == team
    }

    @Test
    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/team/list'


        def team = new Team()

        // TODO: populate valid domain properties

        assert team.save() != null

        params.id = team.id

        def model = controller.edit()

        assert model.teamInstance == team
    }

    @Test
    void testUpdate() {

        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/team/list'

        response.reset()


        def team = new Team()

        // TODO: populate valid domain properties

        assert team.save() != null

        // test invalid parameters in update
        params.id = team.id

        controller.update()

        assert view == "/team/edit"
        assert model.teamInstance != null

        team.clearErrors()

        // TODO: populate valid domain form parameter
        controller.update()

        assert response.redirectedUrl == "/team/show/$team.id"
        assert flash.message != null
    }

    @Test
    void testDelete() {
        controller.delete()

        assert flash.message != null
        assert response.redirectedUrl == '/team/list'

        response.reset()

        def team = new Team()

        // TODO: populate valid domain properties
        assert team.save() != null
        assert Team.count() == 1

        params.id = team.id

        controller.delete()

        assert Team.count() == 0
        assert Team.get(team.id) == null
        assert response.redirectedUrl == '/team/list'


    }


}