using ButtonGrid.Models;
using Microsoft.AspNetCore.Mvc;

namespace ButtonGrid.Controllers
{
    public class ButtonController : Controller
    {
        static List<ButtonModel> buttons = new();
        private Random random = new();
        const int GRID_SIZE = 25;

        public IActionResult Index()
        {
            buttons = new List<ButtonModel>();

            for (int i = 0; i < GRID_SIZE; i++)
            {
                buttons.Add(new ButtonModel(i, random.Next(4)));
            }

            return View("Index", buttons);
        }

        [HttpPost]
        public IActionResult HandleButtonClick(int buttonId)
        {
            // Handle the button click based on the buttonId
            // Add your logic here

            return RedirectToAction("Index");
        }
    }
}