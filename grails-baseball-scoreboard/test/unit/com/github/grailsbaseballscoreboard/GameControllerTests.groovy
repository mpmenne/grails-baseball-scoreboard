package com.github.grailsbaseballscoreboard



import org.junit.*
import grails.test.mixin.*


@TestFor(GameController)
@Mock(Game)
class GameControllerTests {


    @Test
    void testIndex() {
        controller.index()
        assert "/game/list" == response.redirectedUrl
    }

    @Test
    void testList() {

        def model = controller.list()

        assert model.gameInstanceList.size() == 0
        assert model.gameInstanceTotal == 0

    }

    @Test
    void testCreate() {
       def model = controller.create()

       assert model.gameInstance != null


    }

    @Test
    void testSave() {
        controller.save()

        assert model.gameInstance != null
        assert view == '/game/create'

        // TODO: Populate valid properties

        controller.save()

        assert response.redirectedUrl == '/game/show/1'
        assert controller.flash.message != null
        assert Game.count() == 1
    }


    @Test
    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/game/list'


        def game = new Game()

        // TODO: populate domain properties

        assert game.save() != null

        params.id = game.id

        def model = controller.show()

        assert model.gameInstance == game
    }

    @Test
    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/game/list'


        def game = new Game()

        // TODO: populate valid domain properties

        assert game.save() != null

        params.id = game.id

        def model = controller.edit()

        assert model.gameInstance == game
    }

    @Test
    void testUpdate() {

        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/game/list'

        response.reset()


        def game = new Game()

        // TODO: populate valid domain properties

        assert game.save() != null

        // test invalid parameters in update
        params.id = game.id

        controller.update()

        assert view == "/game/edit"
        assert model.gameInstance != null

        game.clearErrors()

        // TODO: populate valid domain form parameter
        controller.update()

        assert response.redirectedUrl == "/game/show/$game.id"
        assert flash.message != null
    }

    @Test
    void testDelete() {
        controller.delete()

        assert flash.message != null
        assert response.redirectedUrl == '/game/list'

        response.reset()

        def game = new Game()

        // TODO: populate valid domain properties
        assert game.save() != null
        assert Game.count() == 1

        params.id = game.id

        controller.delete()

        assert Game.count() == 0
        assert Game.get(game.id) == null
        assert response.redirectedUrl == '/game/list'


    }


}